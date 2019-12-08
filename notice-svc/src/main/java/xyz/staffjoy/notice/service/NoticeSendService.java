package xyz.staffjoy.notice.service;

import com.github.structlog4j.ILogger;
import com.github.structlog4j.SLoggerFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import xyz.staffjoy.notice.dto.NoticeRequest;
import xyz.staffjoy.notice.model.Notice;
import xyz.staffjoy.notice.repo.NoticeRepo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
@RequiredArgsConstructor
public class NoticeSendService {

    static ILogger logger = SLoggerFactory.getLogger(NoticeSendService.class);

    @Autowired
    private final NoticeRepo noticeRepo;

    @PersistenceContext
    private EntityManager entityManager;

    @Async
    public void sendAsync(NoticeRequest request) {
        Notice notice = Notice.builder()
                .name(request.getName())
                .toaddr(request.getTo())
                .subject(request.getSubject())
                .content(request.getContent())
                .build();

        try {
            noticeRepo.save(notice);
        } catch (Exception e) {
            String errMsg = "Could not create notice";
            logger.warn(errMsg);
        }
    }
}
