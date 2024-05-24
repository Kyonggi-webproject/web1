package webLogin.member;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class Favorite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(name = "photo_id")
    private Long photoId;

    @Column(name = "gender")  // 추가
    private String gender;

    public Favorite(Member member, Long photoId, String gender) {  // 수정
        this.member = member;
        this.photoId = photoId;
        this.gender = gender;  // 추가
    }

    // Getters and Setters (if not using Lombok)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Long getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Long photoId) {
        this.photoId = photoId;
    }

    public String getGender() {  // 추가
        return gender;
    }

    public void setGender(String gender) {  // 추가
        this.gender = gender;
    }
}
