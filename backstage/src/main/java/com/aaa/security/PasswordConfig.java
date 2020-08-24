package com.aaa.security;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordConfig implements PasswordEncoder {

    /**
     * 编码
     *
     * @param charSequence 表单提交的密码
     * @return
     */
    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    /**
     * 匹配
     *
     * @param charSequence 表单提交的密码
     * @param s 用户的真实密码
     * @return
     */
    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return charSequence.toString().equals(s);
    }
}
