package gdsc.blog.dto.music;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
public class WriteMusicReq {
    @ApiModelProperty(example = "노래 제목")
    private String name;

    @ApiModelProperty(example = "가수 이름")
    private String singer;

    @ApiModelProperty(example = "앨범 커버 Url")
    private String albumCover;

    @Builder
    public WriteMusicReq(String name, String singer, String albumCover){
        this.name = name;
        this.singer = singer;
        this.albumCover = albumCover;
    }
}
