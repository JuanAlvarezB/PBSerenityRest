#Author: Juan Camilo Alvarez Barrios

Feature: Consumir servicio de reqris.in

  Background:
    Given I consumer URL base

  @TipoGet
  Scenario Outline: Consumer reqres.in tipo Get
    When consume the reqres.in service
    Then validate the <statusCode> the service
    And validate "<schema>" the response
    Examples:
      | statusCode | schema |
      | 200        | REQRES |

