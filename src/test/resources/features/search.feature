Feature: Hotel search
  Scenario: Searching hotel in Minsk
    Given Keyword for search is "DoubleTree by Hilton Minsk"
    When Searching hotels in location
    Then Booking hotel on the first page is "DoubleTree by Hilton Minsk", "Superb"

    
    