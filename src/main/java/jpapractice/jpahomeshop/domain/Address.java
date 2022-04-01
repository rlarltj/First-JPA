package jpapractice.jpahomeshop.domain;


import javax.persistence.Embeddable;

@Embeddable
class Address{
    private String city;

    private String street;

    private String zipcode;
}