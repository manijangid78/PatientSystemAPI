package com.example.PatientSystem.filter;

import com.example.PatientSystem.service.MyUser;
import com.example.PatientSystem.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JWTFilter extends OncePerRequestFilter {

    @Autowired
    private MyUser myUser;

    @Autowired
    private JWTUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

//      get the token from the header.
        final String authorizationHeader = request.getHeader("Authorization");

        String username = null;
        String jwt=null;

//        check toekn is null or not
        if(authorizationHeader!=null){
            jwt = authorizationHeader;
            username = jwtUtil.getUsernameFromToken(jwt);
        }

//        check username is not null and checks that security content is available or not
        if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null){

//            created a userDetails with help to myUser class method
            UserDetails userDetails = myUser.loadUserByUsername(username);

//            check that token is validate or not
            if(jwtUtil.validateToken(jwt,userDetails)){

//                a object is created that simply define the username and password
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new
                        UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

//                security content is added to the security context holder
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
        filterChain.doFilter(request, response);
    }

}
