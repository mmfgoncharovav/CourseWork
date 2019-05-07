using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using Domain.Abstract;
using Domain.Entities;

namespace WebUI.Controllers
{
    public class FilmController : Controller
    {
        private IFilmRepository repository;
        public FilmController(IFilmRepository repo)
        {
            repository = repo;
        }
        public ViewResult List()
        {
            return View(repository.Films);
        }
    }
}