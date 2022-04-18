package Alchemystar.domain.service.validaiton;

import Alchemystar.domain.member.Member;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class MemberValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return Member.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Member member = (Member) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"email","required");


//        if (item.getPrice() == null || item.getPrice() < 1000 ||
//                item.getPrice() > 1000000) {
//            errors.rejectValue("price", "range", new Object[]{1000, 1000000},
//                    null);
//        }


    }
}
