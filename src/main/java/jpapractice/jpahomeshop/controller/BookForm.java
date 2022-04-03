package jpapractice.jpahomeshop.controller;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter @Setter
public class BookForm {

    private Long id;

    @NotEmpty(message = "필수 입력사항입니다.")
    private String name;

//    @NotEmpty(message = "가격을 입력해주세요.")
    private int price;

    private int stockQuantity;

    private String author;

    private String isbn;
}
