package com.example.gogguchips.api.users;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsersService {

    private final UsersMapper usersMapper;
    private final PasswordEncoder passwordEncoder;
    private final JavaMailSender mailSender;

    private final Map<String, UsersData> pendingUsers = new ConcurrentHashMap<>();

    // 생성 및 이메일 인증 보내기 매서드 여결
    public boolean registerUser(UsersData user) {
        try {
            user.setId(UUID.randomUUID().toString());
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            String token = UUID.randomUUID().toString();
            pendingUsers.put(token, user);
            sendVerificationEmail(user.getEmail(), token);
            return true;
        } catch(Exception e){
            return false;
        }
    }

    // 인증메일 보내기
    private void sendVerificationEmail(String email, String token) {
        String link = "http://localhost:8080/api/auth/verify-email?token=" + token;
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("이메일 인증");
        message.setText("이메일을 인증하려면 아래 링크를 클릭하세요:\n" + link);
        mailSender.send(message);
    }

    // 이메일 인증 확인
    public UsersData verifyEmailToken(String token) {
        UsersData user = pendingUsers.get(token);
        if (user != null) {
            pendingUsers.remove(token);
            usersMapper.insertUser(user);
            return user;
        }
        return null;
    }
    // 유저 조회
    public UsersData findByAccount(String account) {
        return usersMapper.selectUserByAccount(account);
    }
}