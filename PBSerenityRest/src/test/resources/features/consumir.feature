#Author: Juan Camilo Alvarez Barrios
@ConsumirSerenityRest
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

  @TipoPost
  Scenario Outline: Consumer reqris.in by methor POST
    When consume method POST by reqres service
    Then the service response <statuscode>
    And validate "<schema>" the service by method POST
    And validate "<email>" of user
    Examples:
      | statuscode | schema     | email              |
      | 201        | METHODPOST | eve.holt@reqres.in |

  @TipoPut
  Scenario Outline: Consumer reqris.in by method PUT
    When consume method PUT by reqres service
    Then the service status response <statuscode>
    And validate "<schema>" the service by method PUT
    And validate the "<name>" of user
    Examples:
      | statuscode | schema    | name     |
      | 200        | METHODPUT | morpheus |