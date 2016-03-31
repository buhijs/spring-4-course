package books.config;

import books.aop.Minstrel;
import books.knights.BraveKnight;
import books.knights.Knight;
import books.knights.Quest;
import books.knights.SlayDragonQuest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class KnightConfig {
    @Bean
    public Knight knight() {
        return new BraveKnight(quest());
    }

    @Bean
    public Quest quest() {
        return new SlayDragonQuest(System.out);
    }

    @Bean
    public Minstrel minstrel() {
        return new Minstrel(System.out);
    }
}
