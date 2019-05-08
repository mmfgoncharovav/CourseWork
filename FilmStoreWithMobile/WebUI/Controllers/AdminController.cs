using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using Domain.Abstract;
using Domain.Entities;
namespace WebUI.Controllers
{
    public class AdminController : Controller
    {
        IFilmRepository repository;

        public AdminController(IFilmRepository repo)
        {
            repository = repo;
        }

        public ViewResult Index()
        {
            return View(repository.Films);
        }
        public ViewResult Edit(int filmId)
        {
            Film film = repository.Films
                .FirstOrDefault(g => g.FilmId == filmId);
            return View(film);
        }
        [HttpPost]
        public ActionResult Edit(Film film)
        {
            if (ModelState.IsValid)
            {
                repository.SaveFilm(film);
                TempData["message"] = string.Format("Изменения в информации о фильме \"{0}\" были сохранены", film.Name);
                return RedirectToAction("Index");
            }
            else
            {
                // Что-то не так со значениями данных
                return View(film);
            }
        }
    }
}