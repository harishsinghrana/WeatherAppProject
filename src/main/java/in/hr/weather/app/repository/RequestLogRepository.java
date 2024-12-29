package in.hr.weather.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import in.hr.weather.app.model.RequestLog;

@Repository
public interface RequestLogRepository extends JpaRepository<RequestLog, Long>{

}
