package com.example.moattravel2.form;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.Data;

@Data
public class ReviewForm {

    @NotNull(message = "評価を選択してください。")
    @Min(value = 1, message = "評価は1以上にしてください。")
    @Max(value = 5, message = "評価は5以下にしてください。")
    private Integer score;

    @NotBlank(message = "コメントを入力してください。")
    @Size(max = 1000, message = "コメントは1000文字以内で入力してください。")
    private String comment;
}