package webLogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import webLogin.member.Favorite;

import java.util.List;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
    List<Favorite> findByMemberId(Long memberId);
    List<Favorite> findByMemberIdAndPhotoId(Long memberId, Long photoId);
    List<Favorite> findByMemberIdAndBrand(Long memberId, String brand);
    List<Favorite> findByMemberIdAndTab(Long memberId, String tab); // tab으로 검색하는 메서드 추가
}
