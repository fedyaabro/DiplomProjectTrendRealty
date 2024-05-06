package testdata;

public enum Builds {
  SPB_BUILDER("ЖК «Цветной город»", "https://trendrealty.ru/object/tsvetnoy_gorod");
  
  public final String buildNameTitle;
  public final String buildNameUrl;
  
  Builds(String buildNameTitle, String buildNameUrl) {
    
    this.buildNameTitle = buildNameTitle;
    this.buildNameUrl = buildNameUrl;
  }
  
}
