package com.example.mois_bussiness.data_loader;

import com.example.mois_bussiness.domain.Tag;
import com.example.mois_bussiness.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TagDataLoader implements CommandLineRunner {

    private final TagRepository tagRepository;

    @Override
    public void run(String... args) throws Exception {
        loadTagData();
    }

    private void loadTagData() {
        if (tagRepository.count() == 0) {
            Tag tag1 = new Tag( 1l, "Vzdelavany", true);
            Tag tag2 = new Tag( 2l, "Kultura", true);
            Tag tag3 = new Tag( 3l, "Leto", true);
            Tag tag4 = new Tag( 4l, "Plaz", true);
            Tag tag5 = new Tag( 5l, "Zima", true);
            Tag tag6 = new Tag( 6l, "Hory", true);
            Tag tag7 = new Tag( 7l, "Mesto", true);
            Tag tag8 = new Tag( 8l, "Venkov", true);
            Tag tag9 = new Tag( 9l, "Lazne", true);
            Tag tag10 = new Tag( 10l, "Valenty", true);
            Tag tag11 = new Tag( 11l, "Halloween", true);
            Tag tag12 = new Tag( 12l, "Vanoce", true);

            tagRepository.save(tag1);
            tagRepository.save(tag2);
            tagRepository.save(tag3);
            tagRepository.save(tag4);
            tagRepository.save(tag5);
            tagRepository.save(tag6);
            tagRepository.save(tag7);
            tagRepository.save(tag8);
            tagRepository.save(tag9);
            tagRepository.save(tag10);
            tagRepository.save(tag11);
            tagRepository.save(tag12);
        }
        System.out.println(tagRepository.count());
    }
}
