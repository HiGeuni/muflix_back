package gdsc.blog.dto.music;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class WriteMusicReq {

    @NotBlank(message = "노래 제목은 필수 입력 값입니다.")
    @ApiModelProperty(example = "노래 제목")
    private String name;

    @NotBlank(message = "가수 이름는 필수 입력 값입니다.")
    @ApiModelProperty(example = "가수 이름")
    private String singer;

    @NotBlank(message = "앨범 커버 URL은 필수 입력 값입니다.")
    @ApiModelProperty(example = "앨범 커버 Url")
    private String albumCover;

    @Builder
    public WriteMusicReq(String name, String singer, String albumCover){
        this.name = name;
        this.singer = singer;
        this.albumCover = albumCover;
    }
}
