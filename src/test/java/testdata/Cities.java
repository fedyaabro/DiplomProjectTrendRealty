package testdata;

public enum Cities {
  
  MOSCOW("Москва", "https://msk.trendrealty.ru/"),
  SPB("Санкт-Петербург", "https://trendrealty.ru/"),
  NSK("Новосибирск", "https://nsk.trendrealty.ru/");
  
  public final String cityName;
  public final String cityUrl;
  
  Cities(String cityName, String cityUrl) {
    
    this.cityName = cityName;
    this.cityUrl = cityUrl;
    
  }
}
