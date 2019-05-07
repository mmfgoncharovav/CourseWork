using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using Domain.Abstract;
using Domain.Entities;
using WebUI.Models;

namespace WebUI.Controllers
{
    public class FilmController : Controller
    {
        private IFilmRepository repository;
        public int pageSize = 3;
        public FilmController(IFilmRepository repo)
        {
            repository = repo;
        }
        public ViewResult List(int page = 1)
        {
            FilmListViewModel model =new FilmListViewModel
            {
                Films = repository.Films
                .OrderBy(Film => Film.FilmId)
                .Skip((page - 1) * pageSize)
                .Take(pageSize),
                PagingInfo = new PagingInfo
                {
                    CurrentPage = page,
                    ItemsPerPage = pageSize,
                    TotalItems = repository.Films.Count()
                }
            };
            return View(model);
        }
    }
}