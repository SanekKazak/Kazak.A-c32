package org.build_patterns.builder;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@ToString
public class AnswerFromDateForm {
    private int year;
    private int month;
    private int day;

    public static class AnswerBuilder{
        private int year;
        private int month;
        private int day;

        public AnswerBuilder setYear(int year){
            if(year < 2025){
                this.year = year;
            }
            return this;
        }
        public AnswerBuilder setMonth(int month){
            if(month < 12 && month > 0){
                this.month = month;
            }
            return this;
        }
        public AnswerBuilder setDay(int day){
            if(day < 30 && day > 0){
                this.day = day;
            }
            return this;
        }
        public AnswerFromDateForm get(){
            return new AnswerFromDateForm(this.year, this.month, this.day);
        }
    }
}
