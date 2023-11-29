package org.java.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.java.spring.pojo.Movie;
import org.java.spring.pojo.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class MainController {

	@GetMapping("/")
	public String BestYear(Model model) {
		final String name = "Alessio";
		
		model.addAttribute("name", name);
		
		return "BestYear";
	}
	
private List<Movie> getBestMovies(){
        
        List<Movie> movies = new ArrayList<>();
        
        Movie m1 = new Movie(1, "The First Slam Dunk");
        movies.add(m1);
        
        Movie m2 = new Movie(2, "Past Lives");
        movies.add(m2);
        
        Movie m3 = new Movie(3, "BlackBerry");
        movies.add(m3);
        
        Movie m4 = new Movie(4, "Rye Lane");
        movies.add(m4);
        
        Movie m5 = new Movie(5, "JoyLand");
        movies.add(m5);
        
        return movies;
    }
   
	
	@GetMapping("/movies")
    public String movies(Model model) {
        
		 List<Movie> movieList = getBestMovies();
        
//        for (Movie m : getBestMovies()) {
//            
//            if(m.getId() < getBestMovies().size()) {
//                
//                movieList += m.getTitolo() + ", ";
//                
//            } else {
//                movieList += m.getTitolo();
//            }
//        }
        
        model.addAttribute("movies", movieList);
        
        return "movies";
    }
	
	@GetMapping("/movie/{id}")
	public String Movie(Model model, @PathVariable int id) {
		
		List<Movie> movies = getBestMovies();
		for (Movie m : movies) {
			if(m.getId() == id) {
				model.addAttribute("id", id);
				model.addAttribute("movie", m);
				
				return "movie";    
	        }
		}
		return "Film non trovato";
	}
    
	 private List<Song> getBestSongs(){
	        
	        List<Song> songs = new ArrayList<>();
	        
	        Song s1 = new Song(1, "Don’t Hate Me");
	        songs.add(s1);
	        
	        Song s2 = new Song(2, "Lil Boo Thang");
	        songs.add(s2);
	        
	        Song s3 = new Song(3, "Jealousy");
	        songs.add(s3);
	        
	        Song s4 = new Song(4, "Sorry Not Sorry");
	        songs.add(s4);
	        
	        Song s5 = new Song(5, "Not Strong Enough");
	        songs.add(s5);
	        
	        return songs;
	    }
	
    @GetMapping("/songs")
    public String songs(Model model) {
        
    	List<Song> songList = getBestSongs();
//        songs = "";
//        
//        for (Song s : getBestSongs()) {
//            
//            if(s.getId() < getBestSongs().size()) {
//                
//                songs += s.getTitolo() + ", ";
//                
//            } else {
//                songs += s.getTitolo();
//            }
//        }
        
        model.addAttribute("songs", songList);
        
        return "songs";
    }
    
    @GetMapping("/song/{id}")
	public String Song(Model model, @PathVariable int id) {
		
    	List<Song> songs = getBestSongs();
		for (Song s : songs) {
			if(s.getId() == id) {
	                
			model.addAttribute("id", id);
			model.addAttribute("song", s);
			
			return "song";  
           
	        }
		}
		return "Canzone non trovato";
	}
}
