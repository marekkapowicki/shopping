package pl.marekk.shopping.shopping.product.domain;

import org.apache.commons.lang3.StringUtils;

public enum ProductName {
  APPLE, ORANGE, BANANA, PAPAYA;

  @Override
  public String toString() {
    return StringUtils.capitalize(this.name().toLowerCase());
  }
}
