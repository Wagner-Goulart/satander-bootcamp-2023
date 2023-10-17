# Satander-bootcamp-2023

## Diagrama de Classes

```mermaid
classDiagram
  class User {
    id: int
    name: string
    account: Account
    card: Card
    features: Feature[]
    news: News[]
  }

  class Account {
    id: int
    number: string
    agency: string
    balance: float
    limit: float
  }

  class Card {
    id: int
    number: string
    limit: float
  }

  class Feature {
    id: int
    icon: string
    description: string
  }

  class News {
    id: int
    icon: string
    description: string
  }

  User "1" *-->"1" Account
  User "1"*-->"1" Card
  User "1" *-->"N" Feature
  User "1"*-->"N" News
```
