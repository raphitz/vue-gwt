package com.axellience.vuegwtexamples.client.examples.evennumbers;

import com.axellience.vuegwt.core.annotations.component.Component;
import com.axellience.vuegwt.core.annotations.component.Computed;
import com.axellience.vuegwt.core.annotations.component.Data;
import com.axellience.vuegwt.core.client.component.IsVueComponent;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import jsinterop.annotations.JsProperty;

@Component
public class EvenNumbersComponent implements IsVueComponent {

  @Data
  @JsProperty
  List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

  @Computed
  public List<Integer> getEvenNumbers() {
    return this.numbers.stream().filter(number -> number % 2 == 0).collect(Collectors.toList());
  }
}