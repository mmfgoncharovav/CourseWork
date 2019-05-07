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
    public class CartController : Controller
    {
        private IFilmRepository repository;
        public CartController(IFilmRepository repo)
        {
            repository = repo;
        }

        public ViewResult Index(Cart cart, string returnUrl)
        {
            return View(new CartIndexViewModel
            {
                Cart = cart,
                ReturnUrl = returnUrl
            });
        }

      
        public RedirectToRouteResult AddToCart(Cart cart ,int filmId, string returnUrl)
        {
            Film film = repository.Films
                .FirstOrDefault(f => f.FilmId == filmId);

            if (film != null)
            {
                cart.AddItem(film, 1);
            }
            return RedirectToAction("Index", new { returnUrl });
        }

        public RedirectToRouteResult RemoveFromCart(Cart cart, int filmId, string returnUrl)
        {
            Film film = repository.Films
                .FirstOrDefault(f => f.FilmId == filmId);

            if (film != null)
            {
                cart.RemoveLine(film);
            }
            return RedirectToAction("Index", new { returnUrl });
        }

        //public Cart GetCart()
        //{
        //    Cart cart = (Cart)Session["Cart"];
        //    if (cart == null)
        //    {
        //        cart = new Cart();
        //        Session["Cart"] = cart;
        //    }
        //    return cart;
        //}
    }
}
