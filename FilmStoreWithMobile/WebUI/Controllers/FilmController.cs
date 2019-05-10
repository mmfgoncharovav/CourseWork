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
        public ViewResult List(string genre, int page = 1)
        {
            FilmListViewModel model = new FilmListViewModel
            {
                Films = repository.Films
                .Where(p => genre == null || p.Genre == genre)
                .OrderBy(Film => Film.FilmId)
                .Skip((page - 1) * pageSize)
                .Take(pageSize),
                PagingInfo = new PagingInfo
                {
                    CurrentPage = page,
                    ItemsPerPage = pageSize,
                    TotalItems = genre == null ?
                    repository.Films.Count():
                    repository.Films.Where(film=>film.Genre==genre).Count()
                },
                CurrentGenre = genre

            };
            return View(model);
        }
        public FileContentResult GetImage(int filmId)
        {
            Film film = repository.Films
                .FirstOrDefault(g => g.FilmId == filmId);

            if (film != null)
            {
                return File(film.ImageData, film.ImageMimeType);
            }
            else
            {
                return null;
            }
        }
    }
}