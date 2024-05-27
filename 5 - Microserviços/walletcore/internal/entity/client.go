package entity

import (
	"time"

	"github.com/google/uuid"
)

type Client struct {
	ID        string
	Name      string
	Email     string
	CratedAt  time.Time
	UpdatedAt time.Time
}

func NewClient(name string, email string) (*Client, error) {
	return &Client{
		ID:        uuid.New().String(),
		Name:      name,
		Email:     email,
		CratedAt:  time.Now(),
		UpdatedAt: time.Now(),
	}, nil
}
