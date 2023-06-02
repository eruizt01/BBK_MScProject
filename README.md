# BBK_MScProject
A Graph-Based Database Application for Cartel Investigations

This document contains the description of what the dummy database should contain.

## * The Case *

The database is loosely based on the price-fixing case involving online sellers that sold their products through Amazon's UK website. The cartelists used a pricing software not to undercut each others prices.

CMA's notes on the case:
https://www.gov.uk/government/case-studies/online-sellers-price-fixing-case-study . 

As I happen to be an amateur boxing aficionado, this fictional case will involve boxing accessories.


## Nodes

 -Firm: 
 
	 The DB will have 3 fictional firms.
	 1. PunchGear Co.
	 2. K.O. Inc.
	 3. TysonJab Ltd.

-Person:

	Every person that might be relevant to the conduct.

-EmailAccount

	- We will assume every person has at least one email account.

-SocialMediaAccount

	- We will assume every person has at least one SMA.

-Communication

		- Both intra-firm or extra-firm

-Product

	- The following are the products for sale:
		- Boxing gloves
		- Hand wraps
		- Skipping rope
		- Punching bag
		- Mouth Guard
	
		We will assume every firm sells every product, with the exception of TysonJab Ltd., that only sells boxing gloves, hand wraps and punching bags.

Brand:

		- Every firm owns different Brands, and each product may be branded differently by individual firms.
		1. PunchGear Co.
		   a)  "PowerPunch (c)", and labels as such the Boxing Gloves, Hand wraps and the punching bags.
		   b)  "PowerBite" is the brand of the mouth guards.
		   c)  "PowerRope" is the brand of the skipping ropes.
		2. K.O. Inc.
		   a)  "K.O.", and labels as such the Boxing Gloves, Hand wraps and the punching bags.
		   b)  "K.O. GumSecure" is the brand of the mouth guards.
		   c) "K.O. Jumper" is the brand of the skipping ropes.
		 3. TysonJab:
				  All boxing gloves, hand wraps and punching bags are sold under the brand "TysonJab".
		
		
Sales
		- Every firm owns different Brands, and each product may be branded differently by individual firms. 

## Properties

### Firm
	- Name
	- Brands
	

### Person
	- Name
	- Surname
	- Age
	- Role

*Roles*:  The hierarchy of the roles will be defined by an array . For example:

role: ['CEO', 'VP Sales', 'Senior Sales Manager', 'SalesExecutive'] will represent a Sales Executive, with all the hierarchy

### Email Account
	- Name
	- Surname
	- Age
	- Role

## Brand
	- Name

### Product
	- Name
	- Category

### Sales
	- Date
	- Hour
	- Price
	- Quantity

## Relationships

Person --[Person-Firm]--> Firm : Represent affiliation or employment
Person --[Person-EmailAccount]--> EmailAccount  : Links a person with their email account.
Person --[Person-SocialMediaAccount]--> SocialMediaAccount : Links a person with their email account.
Firm --[Firm-Product]--> Product: Represets a firm that distributes or manufactures a given product.
Firm --[Firm-Brand]--> Product: Represets a firm that owns a Brand.
Product --[Product-Brand]--> Links a product with its brand. 
Product--[Product-Sale]--> Sale 
Firm --[Firm-Sale]--> Sale: Links a Firm with an individual sale.



## Labels



