package rowan.app.data.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum TokenType {

    ACCESS_TOKEN(1000L * 60 * 5),

    REFRESH_TOKEN(1000L * 60 * 60 * 24 * 30 * 3),

    REFRESH_TOKEN_RENEWAL(1000L * 60 * 60 * 24 * 30 );

    private final Long expiredTime;

}
