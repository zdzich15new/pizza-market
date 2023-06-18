package pl.wszib.pizzamarket.services;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.wszib.pizzamarket.data.entities.ReviewEntity;
import pl.wszib.pizzamarket.data.repositories.ReviewRepository;
import pl.wszib.pizzamarket.web.mappers.ReviewMapper;
import pl.wszib.pizzamarket.web.models.ReviewModel;

import java.util.List;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<ReviewModel> findAll() {
        List<ReviewEntity> entities = reviewRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));

        return entities.stream()
                .map(ReviewMapper::toModel)
                .toList();
    }

    public ReviewModel getById(Long reviewId) {
        ReviewEntity reviewEntity = reviewRepository.findById(reviewId).orElseThrow(EntityNotFoundException::new);

        return ReviewMapper.toModel(reviewEntity);
    }

    @Transactional
    public void saveReview(ReviewModel reviewModel) {

        ReviewEntity reviewValuesEntity = ReviewMapper.toEntity(reviewModel);

        ReviewEntity reviewEntity = new ReviewEntity();
        reviewEntity.setFirstName(reviewValuesEntity.getFirstName());
        reviewEntity.setLastName(reviewValuesEntity.getLastName());
        reviewEntity.setReview(reviewValuesEntity.getReview());

        reviewRepository.save(reviewEntity);
    }
}
