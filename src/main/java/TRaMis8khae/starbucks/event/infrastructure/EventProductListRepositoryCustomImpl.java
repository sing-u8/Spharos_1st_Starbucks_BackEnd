package TRaMis8khae.starbucks.event.infrastructure;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class EventProductListRepositoryCustomImpl implements EventProductListRepositoryCustom {

    private final JPAQueryFactory queryFactory;

//    @Override
//    public Slice

}
