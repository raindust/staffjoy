package xyz.staffjoy.notice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import xyz.staffjoy.common.api.BaseResponse;
import xyz.staffjoy.notice.NoticeConstant;
import xyz.staffjoy.notice.dto.NoticeRequest;

import javax.validation.Valid;

@FeignClient(name = NoticeConstant.SERVICE_NAME, path = "/v1", url = "${staffjoy.notice-service-endpoint}")
public interface NoticeClient {
    @PostMapping(path = "/send")
    BaseResponse send(@RequestBody @Valid NoticeRequest request);
}
