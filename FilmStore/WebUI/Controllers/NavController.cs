using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using Domain.Abstract;


namespace WebUI.Controllers
{
    public class NavController : Controller
    {
        private IFilmRepository repository;

        public NavController(IFilmRepository repo)
        {
            repository = repo;
        }
        public PartialViewResult Menu(string genre=null)
        {
            ViewBag.SelectedGenre = genre;

            IEnumerable<string> genres = repository.Films
                .Select(film => film.Genre)
                .Distinct()
                .OrderBy(x => x);
           
            return PartialView("FlexMenu", genres);
        }
        
    }
}