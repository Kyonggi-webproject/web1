package webLogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import webLogin.member.Member;


import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member,Long> {
    Optional<Member> findByEmail(String email);

    //email로 사용자 정보가져옴
    void deleteByEmail(String email);
}
