package com.app.pingpong.domain.team.repository;

import com.app.pingpong.domain.team.entity.Plan;
import com.app.pingpong.global.common.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Long> {
    List<Plan> findAllByTeamIdAndStatusOrderByWastedTimeDesc(Long teamId, Status status);
    List<Plan> findAllByTeamIdAndStatusAndDateBetween(Long teamId, Status status, LocalDate startDate, LocalDate endDate);
    List<Plan> findAllByManagerIdAndStatusAndDateBetween(Long memberId, Status status, LocalDate startDate, LocalDate endDate);
    Optional<Plan> findByIdAndStatus(Long planId, Status status);
    Optional<Plan> findByIdAndTeamIdAndStatus(Long planId, Long teamId, Status status);
    List<Plan> findAllByTeamIdAndDateAndStatus(Long teamId, LocalDate date, Status status);
    List<Plan> findAllByManagerIdAndStatusAndDate(Long managerId, Status active, LocalDate date);
    List<Plan> findAllByTeamIdAndStatusAndDate(Long teamId, Status active, LocalDate date);
    List<Plan> findAllByTeamIdAndManagerIdAndStatusAndDate(Long id, Long currentMemberId, Status active, LocalDate date);
}
