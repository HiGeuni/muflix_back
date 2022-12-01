package gdsc.blog.dto.User;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

@Getter
public class WriteUserReq {
    @ApiModelProperty(example = "email for login")
    private String email;

    @ApiModelProperty(example = "nigkname")
    private String nickname;

    @ApiModelProperty(example = "phonenumber")
    private String phoneNumber;

    @ApiModelProperty(example = "Password")
    private String password;
}
