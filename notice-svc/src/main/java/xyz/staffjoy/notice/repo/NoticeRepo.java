package xyz.staffjoy.notice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.staffjoy.notice.model.Notice;

@Repository
public interface NoticeRepo extends JpaRepository<Notice, String> {
}
