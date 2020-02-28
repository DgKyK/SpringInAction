package sia.tacocloud.domain;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Taco {

    @NotNull
    private String name;
    @Size(min=1, message="You must choose at least 1 ingredient")
    private List<Ingredient> ingredients;

}
