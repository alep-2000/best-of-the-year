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
    public String movies(Model model, String movies) {
        
        movies = "";
        
        for (Movie m : getBestMovies()) {
            
            if(m.getId() < getBestMovies().size()) {
                
                movies += m.getTitolo() + ", ";
                
            } else {
                movies += m.getTitolo();
            }
        }
        
        model.addAttribute("movies", movies);
        
        return "movies";
    }
	
	@GetMapping("/movies/{id}")
	public String Movie(Model model, String movie, @PathVariable int id) {
		
		for (Movie m : getBestMovies()) {
			if(m.getId() == id) {
	                
	                movie = m.getTitolo();
	           
	        }
		}
    	
		model.addAttribute("id", id);
		model.addAttribute("movie", movie);
		
		return "movieShow";
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
    public String songs(Model model, String songs) {
        
        songs = "";
        
        for (Song s : getBestSongs()) {
            
            if(s.getId() < getBestSongs().size()) {
                
                songs += s.getTitolo() + ", ";
                
            } else {
                songs += s.getTitolo();
            }
        }
        
        model.addAttribute("songs", songs);
        
        return "songs";
    }
    
    @GetMapping("/songs/{id}")
	public String Song(Model model, String song, @PathVariable int id) {
		
		for (Movie m : getBestMovies()) {
			if(m.getId() == id) {
	                
	                song = m.getTitolo();
	           
	        }
		}
    	
		model.addAttribute("id", id);
		model.addAttribute("movie", song);
		
		return "SongShow";
	}
}
