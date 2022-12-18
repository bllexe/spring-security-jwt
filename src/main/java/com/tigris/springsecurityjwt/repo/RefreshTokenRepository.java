package com.tigris.springsecurityjwt.repo;

import com.tigris.springsecurityjwt.entities.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken,Long> {
    RefreshToken findByUserId(Long userId);
}
