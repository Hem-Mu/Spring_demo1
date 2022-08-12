package hamster.demo.repository.Member;

import hamster.demo.domain.Member;

import java.util.List;
import java.util.Optional;

public interface Repository {
    Member save(Member member);
    Optional<Member> findByID(Long id);
    Optional<Member> findByName(String name);
    List<Member> findByAll();
}
