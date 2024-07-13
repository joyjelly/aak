package kr.co.sist.aak.domain.student.vo;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ExamResultsForm {
    private List<MyExamVO> examResults;

    public List<MyExamVO> getExamResults() {
        return examResults;
    }

    public void setExamResults(List<MyExamVO> examResults) {
        this.examResults = examResults;
    }
}