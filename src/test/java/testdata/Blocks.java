package testdata;

public enum Blocks {
  TSVETNOY_GOROD("ЖК «Цветной город»", "tsvetnoy_gorod", City.SPB);
  
  public final String name;
  public final String guid;
  public final City city;
  
  Blocks(String name, String guid, City city) {
    
    this.name = name;
    this.guid = guid;
    this.city = city;
  }
  
}
