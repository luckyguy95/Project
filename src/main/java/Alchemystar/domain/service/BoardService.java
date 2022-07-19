package Alchemystar.domain.service;

import Alchemystar.domain.member.User;
import Alchemystar.domain.model.Board;
import Alchemystar.domain.repository.BoardRepository;
import Alchemystar.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private UserRepository userRepository;

    public Board save(String username, Board board) {
        User user = userRepository.findByUsername(username);
        board.setUser(user);
        return boardRepository.save(board);
    }
}
