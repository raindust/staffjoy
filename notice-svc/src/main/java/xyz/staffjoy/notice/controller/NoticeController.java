package xyz.staffjoy.notice.controller;

import com.github.structlog4j.ILogger;
import com.github.structlog4j.SLoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.staffjoy.common.api.BaseResponse;
import xyz.staffjoy.notice.dto.NoticeRequest;
import xyz.staffjoy.notice.service.NoticeSendService;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1")
@Validated
public class NoticeController {

    @Autowired
    private NoticeSendService noticeSendService;

    @PostMapping(path = "/send")
    public BaseResponse send(@RequestBody @Valid NoticeRequest request) {
        noticeSendService.sendAsync(request);
        return BaseResponse.builder().message("content has been sent async.")
                .build();
    }
}
