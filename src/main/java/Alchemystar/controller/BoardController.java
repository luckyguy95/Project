package Alchemystar.controller;

import Alchemystar.domain.model.Board;
import Alchemystar.domain.repository.BoardRepository;
import Alchemystar.domain.service.BoardService;
import Alchemystar.validator.BoardValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/board")
public class BoardController<bindingResult> {

    //@Autowired
    private final BoardRepository boardRepository;
    private final BoardValidator boardValidator;
    private final BoardService boardService;

    public BoardController(BoardRepository boardRepository, BoardValidator boardValidator, BoardService boardService) {
        this.boardRepository = boardRepository;
        this.boardValidator = boardValidator;
        this.boardService = boardService;
    }

    @GetMapping("/list")
    public String listGet(Model model, @PageableDefault(size = 2) Pageable pageable
            , @RequestParam(required = false, defaultValue = "") String searchText
            , @RequestParam(required = false, defaultValue = "") String searchSelection) {
        Page<Board> boards = null;
        log.info("{}, {}", searchSelection.getClass().getName(), searchSelection);
        if(searchSelection.equals("title")){
            boards = boardRepository.findByTitleContaining(searchText, pageable);
        } else if (searchSelection.equals("nickname")) {
            boards = boardRepository.findByUser_NicknameContaining(searchText, pageable);
        } else {
            boards = boardRepository.findByTitleContainingOrContentContaining(searchText, searchText, pageable);
        }


        int startPage = Math.max(1, boards.getPageable().getPageNumber() - 3);
        int endPage = Math.min(boards.getTotalPages(), boards.getPageable().getPageNumber() + 3);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("boards", boards);
        return "board/list";
    }

    @PostMapping("/list")
    public String listPost() {
        return "board/add";
    }


    @GetMapping("/add")
    public String getAdd(Model model) {
        model.addAttribute("board",new Board());
        return "board/add";
    }
    @PostMapping("/add")
    public String postAdd(@Valid Board board, BindingResult bindingResult, Authentication authentication) {
        String username = authentication.getName();
        boardService.save(username, board);

        return "redirect:/board/list";
    }

    @GetMapping("/{id}")
    public String getBoard(Model model, @PathVariable Long id) {
        //@RequestParam(required = false)
        if(id == null) {
            model.addAttribute("board", new Board());
        } else {
            Board board = boardRepository.findById(id).orElse(null);
            model.addAttribute("board", board);
        }
        return "board/form";
        //redirect:/board/list"

    }

    @GetMapping("/{id}/edit")
    public String getEdit(Model model, @PathVariable Long id) {
        if(id == null) {
            model.addAttribute("board", new Board());
        } else {
            Board board = boardRepository.findById(id).orElse(null);
            model.addAttribute("board", board);
        }
        return "board/edit";
    }
    @PostMapping("/{id}/edit")
    public String postEdit(@Valid Board board ,@PathVariable Long id, BindingResult bindingResult, Authentication authentication) {
        boardValidator.validate(board,bindingResult);
        if (bindingResult.hasErrors()) {
            return "board/list";
        }

        String username = authentication.getName();
        boardService.save(username, board);

        return "redirect:/board/list";
    }
}
