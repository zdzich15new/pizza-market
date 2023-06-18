package pl.wszib.pizzamarket.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.wszib.pizzamarket.services.ReviewService;
import pl.wszib.pizzamarket.web.models.ReviewModel;

import java.util.List;

@Controller
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("review")
    public String reviewPage(Model model) {
        List<ReviewModel> reviews = reviewService.findAll();

        model.addAttribute("reviewsList", reviews);
        model.addAttribute("reviewForm", new ReviewModel());
        return "reviewPage";
    }

    @PostMapping("review")
    public String review(@ModelAttribute("reviewForm") ReviewModel reviewModel) {
        reviewService.saveReview(reviewModel);

        return "redirect:/review";
    }
}
