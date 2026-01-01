package com.scheduleapp.service;

import com.scheduleapp.dto.commentdto.CreateCommentRequest;
import com.scheduleapp.dto.commentdto.CreateCommentResponse;
import com.scheduleapp.entity.Comment;
import com.scheduleapp.entity.Schedule;
import com.scheduleapp.repository.CommentRepository;
import com.scheduleapp.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final ScheduleRepository scheduleRepository;

    @Transactional
    public CreateCommentResponse createComment(Long scheduleId, CreateCommentRequest request) {
        Schedule findSchedule = scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalStateException("존재하지 않는 스케줄입니다.")
        );

        if(findSchedule.getComments().size() == 10){
            throw new IllegalStateException("하나의 일정에 댓글은 10개까지만 작성할 수 있습니다.");
        }

        Comment comment = new Comment(
                request.getContents(),
                request.getWriterName(),
                request.getPassword(),
                findSchedule
        );

        findSchedule.addComment(comment);
        Comment savedComment = commentRepository.save(comment);

        return new CreateCommentResponse(
                savedComment.getId(),
                savedComment.getContents(),
                savedComment.getWriterName(),
                savedComment.getCreatedDate(),
                savedComment.getModifiedDate()
        );
    }
}
