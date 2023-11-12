# Points of Interest by GPS (POIs)

Challenge implementation [Points of Interest by GPS](https://github.com/backend-br/desafios/blob/master/points-of-interest/PROBLEM.md), from the backend-br repository.

## Stack
- Java
- Spring boot
- MongoDB

## Problem
XY Lda. is a company specialized in the production of excellent GPS receivers. The administration is committed to launching an innovative device that promises to help people locate POIs and it really needs your help. You were hired to develop the platform that will provide all the intelligence to the device! This platform must be based on REST services, in order to make integration more flexible.

#### Rules
- Create POIs, with 3 attributes: POI name, X coordinate (non-negative integer) and Y coordinate (non-negative integer). POIs must be saved in a database.
- List all POIs created.
- List all POIs by proximity. You will receive an X coordinate and a Y coordinate, specifying a reference point, as well as a maximum distance (dmax) in meters. It must return all POIs in the database that are less than or equal to d-max from the reference point.

#### Database Example
Consider the following POI database:
- 'Cafeteria' (x=27, y=12)
- 'Post' (x=31, y=18)
- 'Jewelry' (x=15, y=12)
- 'Floriculture' (x=19, y=21)
- 'Pub' (x=12, y=8)
- 'Supermarket' (x=23, y=6)
- 'Steakhouse' (x=28, y=2)

#### Example of use
Given the reference point (x=20, y=10) indicated by the GPS receiver, and a maximum distance of 10 meters, the service must return the following POIs:
- Cafeteria
- Jewelry
- Pub
- Supermarket


## Endpoints
### Create POI
Create a point of interest.

**[POST]** `{{host}}/api/poi/create`

**Body**
| Field      | Type | Description                           | Mandatory |
|:---------------|:----:|:------------------------------------|:-----------:|
| `name`     | string  | Name of the point of interest.         |     No     |  
| `x` | double  | X coordinate of the point of interest. |     No     |             
| `y` | double  | Y coordinate of the point of interest. |     No     |
        
```json
{
    "name": "Steakhouse",
    "x": 28.00,
    "y": 2.00
}
```

**Response**

201 Created
```json
{
    "name": "Steakhouse",
    "x": 28.00,
    "y": 2.00
}
```


### List POIs
List all points of interest.

**[GET]** `{{host}}/api/poi/all`

**Response**

200 OK
```json
{
    "name": "Steakhouse",
    "x": 28.00,
    "y": 2.00
}
```


### List POIs by proximity
Given a reference point (`x` e `y`), lists all points of interest that are less than or equal to `dmax`.

**[GET]** `{{host}}/api/poi/distance?x=20&y=10&dmax=10`

**Request**
| Parameter      | Type | Description                           | Mandatory |
|:---------------|:----:|:------------------------------------|:-----------:|
| `x` | double  | X coordinate of the point of interest. |     No     |             
| `y` | double  | Y coordinate of the point of interest. |     No     |
| `dmax`     | double  | Maximum distance in meters.         |     No     |             

**Response**

200 OK
```json
{
    "name": "Steakhouse",
    "x": 28.00,
    "y": 2.00
}
```
