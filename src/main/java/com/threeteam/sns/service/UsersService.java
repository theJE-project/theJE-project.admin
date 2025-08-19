package com.threeteam.sns.service;

import java.util.List
;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import com.threeteam.sns.dto.UsersResponsDto;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.threeteam.sns.dto.UsersDto;
import com.threeteam.sns.dto.UsersPendingDto;
import com.threeteam.sns.mapper.UsersMapper;

import lombok.RequiredArgsConstructor;
import com.threeteam.sns.dto.UsersResponsDto;

@Service
@RequiredArgsConstructor
public class UsersService {

	private final UsersMapper mapper;
	private final PasswordEncoder passwordEncoder;
    private final JavaMailSender mailSender;
    private final Map<String, UsersPendingDto> pendingUsers = new ConcurrentHashMap<>();

	public List<UsersDto> getAll() {
		return mapper.getAll();
	}

	public UsersDto getById(String id) {
		return mapper.getById(id);
	}

	public int insert(UsersDto dto) {
		int result = mapper.insert(dto);
		return result;
	}

	public void update(UsersDto dto) {
		mapper.update(dto);
	}

	public void delete(String id) {
		mapper.delete(id);
	}

	public List<UsersDto> search(UsersDto dto) {
		return mapper.search(dto);
	}
	
	public List<Map<String, Object>> searchList(UsersDto dto) {
		return mapper.searchList(dto);
	}
	
	public UsersDto getByAccount(String account){
        return mapper.getByAccount(account);
    }

    public String registerUser(UsersDto user) {
        try {
            // 계정 중복 체크
            UsersDto existingUserByAccount = mapper.getByAccount(user.getAccount());
            if (existingUserByAccount != null) {
                return "중복된 아이디명이 있습니다.";
            }

            // 이메일 중복 체크 (usersMapper에 이메일 조회 쿼리 메서드 필요)
            UsersDto existingUserByEmail = mapper.getByEmail(user.getEmail());
            if (existingUserByEmail != null) {
                return "이미 가입된 이메일 입니다.";
            }
            user.setId(UUID.randomUUID().toString());
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            String token = UUID.randomUUID().toString();
            pendingUsers.put(token, new UsersPendingDto(user));
            sendVerificationEmail(user.getEmail(), token);
            return null;
        } catch(Exception e){
            e.printStackTrace();
            return "회원가입중 알 수 없는 오류가 발생하였습니다.";
        }
    }

    // 인증메일 보내기
    private void sendVerificationEmail(String email, String token) {
        String link = "http://localhost:5173/#/login/redirect?token=" + token;
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("이메일 인증");
        message.setText("이메일을 인증하려면 아래 링크를 클릭하세요:\n" + link);
        mailSender.send(message);
    }

    // 이메일 인증 확인
    public UsersDto verifyEmailToken(String token) {
        UsersPendingDto pending = pendingUsers.get(token);
        if (pending != null) {
            pendingUsers.remove(token);
            mapper.insert(pending.getUser());
            return pending.getUser();
        }
        return null;
    }

    public String login(String account, String password) {
        try {
            UsersDto user = mapper.getByAccount(account);
            System.out.println(user);
            System.out.println("pw : " + password);
            System.out.println("pw en : " + passwordEncoder.encode(password));
            if (user == null) return "존재하지 않는 계정입니다.";
            if (!passwordEncoder.matches(password, user.getPassword())) return "비밀번호가 일치하지 않습니다.";
            return null;
        } catch (Exception e) {
            return "로그인 중 알 수 없는 오류가 발생했습니다.";
        }
    }

}
